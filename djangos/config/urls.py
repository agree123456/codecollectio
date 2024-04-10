from django.contrib import admin
from django.urls import path, include

from pybo.views import base_views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', base_views.index, name='index'),  # '/' 에 해당되는 path
    path('pybo/', include('pybo.urls')),
    path('common/', include('common.urls')),
    # path('chart/',include('chart.urls')),
]
handler404 = 'common.views.page_not_found'