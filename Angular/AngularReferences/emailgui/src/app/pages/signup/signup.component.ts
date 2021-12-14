import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService: UserService, private snack: MatSnackBar) { }
	public user={
		username:'',
		password:'',	
		firstName:'',
		lastName:'',
		email:'',
		phone:'',
	};
	formSubmit()
	{
		console.log(this.user);
		if(this.user.username == '' || this.user.username == null){
			//alert('username is required');
			//this.snack.open('username is required');
			
			//this.snack.open('username is required','ok');
			
		//	this.snack.open('username is required','',{
		//		duration:3000,});
			//
			this.snack.open('username is required','',{
				duration:3000,verticalPosition:'top'});
			return;
		}
		this.userService.addUser(this.user).subscribe((data)=>{
			console.log(data);
			//alert('success');
			Swal.fire('Successfully done','user id is','success');
		},
			(error)=>{
				console.log(error)
				alert('something went wrong')
			}
		);
	}

  ngOnInit(): void {
  }

}
