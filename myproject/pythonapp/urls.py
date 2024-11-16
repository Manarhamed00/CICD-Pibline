
from django.urls import path
from . import views

urlpatterns = [
    path('add_userinfo/', views.add_userinfo, name='add_userinfo'),
    path('', views.fetch_userinfo, name='fetch_userinfo'),
    path('success_page/', views.success_page, name='success_page'),  # Add this line
]