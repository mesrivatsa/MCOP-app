#if HAVE_CRT
#define _CRTDBG_MAP_ALLOC 
#include <stdlib.h> 
#include <crtdbg.h>
#endif //HAVE_CRT
/*
* Copyright (C) 2017 Eduardo Zarate Lasurtegui
* Copyright (C) 2017, University of the Basque Country (UPV/EHU)
* Contact for licensing options: <licensing-mcpttclient(at)mcopenplatform(dot)com>
*
* The original file was part of Open Source Doubango Framework
* Copyright (C) 2010-2011 Mamadou Diop.
* Copyright (C) 2012 Doubango Telecom <http://doubango.org>
*
* This file is part of Open Source Doubango Framework.
*
* DOUBANGO is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* DOUBANGO is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with DOUBANGO.
*
*/

/**@file tsk_url.c
 * @brief Utility functions to encode/decode urls.
 *
 */
#include "tsk_url.h"
#include "tsk_memory.h"
#include "tsk_string.h"

#include <ctype.h>
#include <string.h>

/**@defgroup tsk_url_group Utility functions to encode/decode urls.
*/


/**@ingroup tsk_url_group
* Encode an url.
* @param url The url to encode
* @retval The encoded url. It is up to you to free the returned string.
*
* @sa tsk_url_decode
*
*/
char* tsk_url_encode(const char* url) {
	#if HAVE_CRT //Debug memory
	char *purl = (char*)url, *buf = (char*)malloc(tsk_strlen(url) * 3 + 1), *pbuf = buf;
		
	#else
	char *purl = (char*)url, *buf = (char*)tsk_malloc(tsk_strlen(url) * 3 + 1), *pbuf = buf;
		
	#endif //HAVE_CRT
	while (*purl) {
		if (isalnum(*purl) || *purl == '-' || *purl == '_' || *purl == '.' || *purl == '~'){
			*pbuf++ = *purl;
		}
		else if (*purl == ' '){
			*pbuf++ = '+';
		}
		else{
			*pbuf++ = '%', *pbuf++ = tsk_b10tob16(*purl >> 4), *pbuf++ = tsk_b10tob16(*purl & 15);
		}
		purl++;
	}
	*pbuf = '\0';
	return buf;
}

/**@ingroup tsk_url_group
* Decode an url.
* @param url The url to encode
* @retval The decoded url. It is up to you to free the returned string.
*
* @sa tsk_url_encode
*/
char* tsk_url_decode(const char* url) {
	#if HAVE_CRT //Debug memory
		char *purl = (char*)url, *buf = (char*)malloc(tsk_strlen(url) + 1), *pbuf = buf;
	
	#else
		char *purl = (char*)url, *buf = (char*)tsk_malloc(tsk_strlen(url) + 1), *pbuf = buf;
	
	#endif //HAVE_CRT
	while (*purl) {
		if (*purl == '%') {
			if (purl[1] && purl[2]) {
				*pbuf++ = tsk_b16tob10(purl[1]) << 4 | tsk_b16tob10(purl[2]);
				purl += 2;
			}
		}
		else if (*purl == '+') {
			*pbuf++ = ' ';
		}
		else {
			*pbuf++ = *purl;
		}
		purl++;
	}
	*pbuf = '\0';
	return buf;
}
