# -*- coding: utf-8 -*-

# Scrapy settings for data_collector project.
# You can find this and more settings consulting the documentation:
#     https://doc.scrapy.org/en/latest/topics/settings.html,
#     https://doc.scrapy.org/en/latest/topics/extensions.html


# The name of the bot implemented by this Scrapy project (also known as the project name).
# This will be used to construct the User-Agent by default, and also for logging.
BOT_NAME = 'data_collector'

# A list of modules where Scrapy will look for spiders
SPIDER_MODULES = ['data_collector.spiders']

# Module where to create new spiders using the "scrapy genspider" command
NEWSPIDER_MODULE = 'data_collector.spiders'

# Enables custom middleware components
SPIDER_MIDDLEWARES = {
    'data_collector.middlewares.SqlConverterMiddleware': 500
}

# Whether to enable the cookies middleware. If disabled, no cookies will
# be sent to web servers. (enabled by default)
COOKIES_ENABLED = False

# A boolean which specifies if the telnet console will be enabled. (enabled by default)
TELNETCONSOLE_ENABLED = False

# ------------------------------------------------------------
# Enable and configure HTTP caching (disabled by default)
# See https://doc.scrapy.org/en/latest/topics/downloader-middleware.html#httpcache-middleware-settings

# Whether the HTTP cache will be enabled
HTTPCACHE_ENABLED = True

# Expiration time for cached requests, in seconds.
# Cached requests older than this time will be re-downloaded. If zero,
# cached requests will never expire.
HTTPCACHE_EXPIRATION_SECS = 0

# The directory to use for storing the (low-level) HTTP cache. If empty, the HTTP cache
# will be disabled. If a relative path is given, is taken relative to the project data dir.
HTTPCACHE_DIR = 'httpcache'

# Don’t cache response with these HTTP codes.
# HTTPCACHE_IGNORE_HTTP_CODES = []
