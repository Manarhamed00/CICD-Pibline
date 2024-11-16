from django.shortcuts import render, redirect
from .models import Userinfo


def index(request):
    return render(request, 'index.html')

def add_userinfo(request):
    if request.method == 'POST':
        
        unique_id = request.POST.get('unique_id')
        date_of_birth = request.POST.get('date_of_birth')
        password = request.POST['password']
        first_name = request.POST.get('first_name','' )
        last_name = request.POST['last_name']
        email = request.POST['email']

        
        userinfo = Userinfo(unique_id=unique_id, date_of_birth=date_of_birth, first_name=first_name, password=password,email=email, last_name=last_name)
        userinfo.save()
        return redirect('success_page')  

    return render(request, 'add_userinfo.html')

def fetch_userinfo(request):
    if request.method == 'POST':
        unique_id = request.POST.get('unique_id')

        try:
            userinfo = Userinfo.objects.get(unique_id=unique_id)
            return render(request, 'userinfo_details.html', {'userinfo': userinfo})
        except Userinfo.DoesNotExist:
            return render(request, 'userinfo_not_found.html')

    return render(request, 'fetch_userinfo.html')

def success_page(request):
    return render(request, 'success_page.html')