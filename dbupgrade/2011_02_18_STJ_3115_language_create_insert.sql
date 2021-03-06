-- Create Language table.

CREATE TABLE CLW_LANGUAGE 
(
  LANGUAGE_ID NUMBER(38, 0) NOT NULL 
, SHORT_DESC VARCHAR2(64 CHAR) NOT NULL 
, UI_NAME VARCHAR2(128 CHAR) NOT NULL 
, LANGUAGE_CODE VARCHAR2(2 CHAR) NOT NULL 
, ADD_DATE DATE NOT NULL 
, ADD_BY VARCHAR2(30 CHAR) NOT NULL 
, MOD_DATE DATE NOT NULL 
, MOD_BY VARCHAR2(30 CHAR) NOT NULL 
) ;

-- Create Sequence for Language table.

CREATE SEQUENCE CLW_LANGUAGE_SEQ INCREMENT BY 1 MAXVALUE 999999999999999999999999999 MINVALUE 1 CACHE 20;

-- Insert data into Language table (CLW_LANGUAGE).

INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ABKHAZIAN','Abkhazian','ab',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'AFAR','Afar','aa',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'AFRIKAANS','Afrikaans','af',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ALBANIAN','Albanian','sq',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'AMHARIC','Amharic','am',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ARABIC','Arabic','ar',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ARAGONESE','Aragonese','an',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ARMENIAN','Armenian','hy',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ASSAMESE','Assamese','as',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'AVESTAN','Avestan','ae',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'AYMARA','Aymara','ay',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'AZERBAIJANI','Azerbaijani','az',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BASHKIR','Bashkir','ba',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BASQUE','Basque','eu',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BELARUSIAN','Belarusian','be',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BENGALI','Bengali','bn',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BIHARI','Bihari','bh',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BISLAMA','Bislama','bi',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BOSNIAN','Bosnian','bs',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BRETON','Breton','br',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BULGARIAN','Bulgarian','bg',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'BURMESE','Burmese','my',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CATALAN','Catalan','ca',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CHAMORRO','Chamorro','ch',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CHECHEN','Chechen','ce',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CHINESE','Chinese','zh',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CHURCH SLAVIC/SLAVONIC/OLD BULGARIAN','Church Slavic/Slavonic/Old Bulgarian','cu',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CHUVASH','Chuvash','cv',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CORNISH','Cornish','kw',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CORSICAN','Corsican','co',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CROATIAN','Croatian','hr',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'CZECH','Czech','cs',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'DANISH','Danish','da',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'DIVEHI/DHIVEHI/MALDIVIAN','Divehi/Dhivehi/Maldivian','dv',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'DUTCH','Dutch','nl',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'DZONGKHA','Dzongkha','dz',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ENGLISH','English','en',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ESPERANTO','Esperanto','eo',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ESTONIAN','Estonian','et',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'FAROESE','Faroese','fo',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'FIJIAN','Fijian','fj',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'FINNISH','Finnish','fi',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'FRENCH','French','fr',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'GAELIC/SCOTTISH GAELIC','Gaelic/Scottish Gaelic','gd',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'GALICIAN','Galician','gl',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'GEORGIAN','Georgian','ka',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'GERMAN','German','de',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'GREEK','Greek','el',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'GUARANI','Guarani','gn',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'GUJARATI','Gujarati','gu',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'HAITIAN/HAITIAN CREOLE ','Haitian/Haitian Creole ','ht',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'HAUSA','Hausa','ha',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'HEBREW','Hebrew','he',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'HERERO','Herero','hz',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'HINDI','Hindi','hi',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'HIRI MOTU','Hiri Motu','ho',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'HUNGARIAN','Hungarian','hu',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ICELANDIC','Icelandic','is',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'IDO','Ido','io',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'INDONESIAN','Indonesian','id',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'INTERLINGUA','Interlingua','ia',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'INTERLINGUE','Interlingue','ie',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'INUKTITUT','Inuktitut','iu',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'INUPIAQ','Inupiaq','ik',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'IRISH','Irish','ga',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ITALIAN','Italian','it',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'JAPANESE','Japanese','ja',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'JAVANESE','Javanese','jv',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KALAALLISUT','Kalaallisut','kl',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KANNADA','Kannada','kn',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KASHMIRI','Kashmiri','ks',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KAZAKH','Kazakh','kk',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KHMER','Khmer','km',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KIKUYU; GIKUYU','Kikuyu; Gikuyu','ki',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KINYARWANDA','Kinyarwanda','rw',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KIRGHIZ','Kirghiz','ky',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KOMI','Komi','kv',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KOREAN','Korean','ko',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KUANYAMA; KWANYAMA','Kuanyama; Kwanyama','kj',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'KURDISH','Kurdish','ku',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'LAO','Lao','lo',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'LATIN','Latin','la',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'LATVIAN','Latvian','lv',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'LIMBURGAN/LIMBURGER/LIMBURGISH','Limburgan/Limburger/Limburgish','li',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'LINGALA','Lingala','ln',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'LITHUANIAN','Lithuanian','lt',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'LUXEMBOURGISH/LETZEBURGESCH','Luxembourgish/Letzeburgesch','lb',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MACEDONIAN','Macedonian','mk',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MALAGASY','Malagasy','mg',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MALAY','Malay','ms',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MALAYALAM','Malayalam','ml',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MALTESE','Maltese','mt',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MANX','Manx','gv',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MAORI','Maori','mi',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MARATHI','Marathi','mr',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MARSHALLESE','Marshallese','mh',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MOLDAVIAN','Moldavian','mo',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'MONGOLIAN','Mongolian','mn',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NAURU','Nauru','na',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NAVAHO/NAVAJO','Navaho/ Navajo','nv',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NDEBELE/NORTH','Ndebele/ North','nd',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NDEBELE/SOUTH','Ndebele/ South','nr',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NDONGA','Ndonga','ng',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NEPALI','Nepali','ne',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NORTHERN SAMI','Northern Sami','se',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NORWEGIAN','Norwegian','no',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NORWEGIAN BOKMAL','Norwegian Bokmal','nb',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NORWEGIAN NYNORSK','Norwegian Nynorsk','nn',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'NYANJA/CHICHEWA/CHEWA','Nyanja/ Chichewa/Chewa','ny',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'OCCITAN /PROVENCAL','Occitan/Provencal','oc',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ORIYA','Oriya','or',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'OROMO','Oromo','om',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'OSSETIAN/OSSETIC','Ossetian/Ossetic','os',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'PALI','Pali','pi',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'PANJABI','Panjabi','pa',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'PERSIAN','Persian','fa',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'POLISH','Polish','pl',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'PORTUGUESE','Portuguese','pt',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'PUSHTO','Pushto','ps',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'QUECHUA','Quechua','qu',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'RAETO-ROMANCE','Raeto-Romance','rm',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ROMANIAN','Romanian','ro',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'RUNDI','Rundi','rn',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'RUSSIAN','Russian','ru',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SAMOAN','Samoan','sm',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SANGO','Sango','sg',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SANSKRIT','Sanskrit','sa',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SARDINIAN','Sardinian','sc',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SERBIAN','Serbian','sr',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SHONA','Shona','sn',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SICHUAN YI','Sichuan Yi','ii',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SINDHI','Sindhi','sd',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SINHALA; SINHALESE','Sinhala; Sinhalese','si',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SLOVAK','Slovak','sk',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SLOVENIAN','Slovenian','sl',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SOMALI','Somali','so',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SOTHO/ SOUTHERN','Sotho/ Southern','st',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SPANISH/ CASTILIAN','Spanish/ Castilian','es',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SUNDANESE','Sundanese','su',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SWAHILI','Swahili','sw',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SWATI','Swati','ss',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'SWEDISH','Swedish','sv',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TAGALOG','Tagalog','tl',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TAHITIAN','Tahitian','ty',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TAJIK','Tajik','tg',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TAMIL','Tamil','ta',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TATAR','Tatar','tt',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TELUGU','Telugu','te',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'THAI','Thai','th',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TIBETAN','Tibetan','bo',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TIGRINYA','Tigrinya','ti',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TONGA (TONGA ISLANDS)','Tonga (Tonga Islands)','to',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TSONGA','Tsonga','ts',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TSWANA','Tswana','tn',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TURKISH','Turkish','tr',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TURKMEN','Turkmen','tk',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'TWI','Twi','tw',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'UIGHUR','Uighur','ug',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'UKRAINIAN','Ukrainian','uk',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'URDU','Urdu','ur',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'UZBEK','Uzbek','uz',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'VIETNAMESE','Vietnamese','vi',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'VOLAPUK','Volapuk','vo',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'WALLOON','Walloon','wa',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'WELSH','Welsh','cy',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'WESTERN FRISIAN','Western Frisian','fy',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'WOLOF','Wolof','wo',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'XHOSA','Xhosa','xh',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'YIDDISH','Yiddish','yi',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'YORUBA','Yoruba','yo',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ZHUANG/CHUANG','Zhuang/Chuang','za',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
INSERT INTO CLW_LANGUAGE VALUES(CLW_LANGUAGE_SEQ.NEXTVAL,'ZULU','Zulu','zu',SYSDATE,'sqlQuery',SYSDATE,'sqlQuery');
COMMIT;