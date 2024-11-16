from django.db import models
from django.contrib.auth.models import AbstractUser

class Userinfo(models.Model):
    unique_id = models.CharField(max_length=20, unique=True)
    date_of_birth = models.DateField()
    password = models.CharField(max_length=128, default='',null=False)
    first_name = models.CharField(max_length=50, default='',null=False)
    email = models.EmailField(default='', null=False)
    last_name= models.CharField(max_length=50, default='',null=False)
    def _str_(self):
        return self.unique_id