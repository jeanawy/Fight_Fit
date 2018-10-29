// Set new default font family and font color to mimic Bootstrap's default styling
/*Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ["Mar 1", "Mar 2", "Mar 3", "Mar 4", "Mar 5", "Mar 6", "Mar 7", "Mar 8", "Mar 9", "Mar 10", "Mar 11", "Mar 12", "Mar 13"],
    datasets: [{
      label: "Sessions",
      lineTension: 0.3,
      backgroundColor: "rgba(2,117,216,0.2)",
      borderColor: "rgba(2,117,216,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(2,117,216,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      pointHitRadius: 50,
      pointBorderWidth: 2,
      data: [10000, 30162, 26263, 18394, 18287, 28682, 31274, 33259, 25849, 24159, 32651, 31984, 38451],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 40000,
          maxTicksLimit: 5
        },
        gridLines: {
          color: "rgba(0, 0, 0, .125)",
        }
      }],
    },
    legend: {
      display: false
    }
  }
});*/


import { Chart } from 'react-google-charts';
import React from 'react';
import {Line} from 'react-chartjs-2'; 
import * as firebase from 'firebase'
import axios from 'axios';
//import { user } from "user-profile";
var config = {
    apiKey: "AIzaSyDpahYAYK5n62WC8J4TxA06PZ_xcJkri_0",
    authDomain: "friendfit-4b304.firebaseapp.com",
    databaseURL: "https://friendfit-4b304.firebaseio.com",
    projectId: "friendfit-4b304",
    storageBucket: "friendfit-4b304.appspot.com",
    messagingSenderId: "396870379349"
 };

const firebaseApp = firebase.initializeApp(config);

class Graph extends React.Component {
    constructor(props){
        super(props)
this.state={
    data:{},
    heartrate:[],
    result:{}
}
    }
    // async getData() {
    //     await firebaseApp.database().ref('HealthProf').on('value', data => {
    //      let heartrate = []
    //       for (var x in data.val()) {
    //         heartrate.push(data.val()[x])
    //        let length = heartrate.length-1
    //         console.log(heartrate[length].heartrate)
    //       }
    //     this.setState({heartrate:heartrate})
    //     })
    //   }
    setHeartRate = async () =>{
        
        await firebaseApp.database().ref('HealthProf').on('value', data => {
            let heartrate = [] 
            for (var x in data.val()) {
               heartrate.push(data.val()[x])
              let length = heartrate.length-1
            //    console.log(heartrate[length].heartrate)
             }
            //  console.log(heartrate[0].heartrate)
                    let fakeHeartrate = heartrate[0].heartrate
       console.log(fakeHeartrate)
     let labels = []
        fakeHeartrate.map((data,index)=>{
            // labels.push(index+1)
            labels.push("")
        })

     let   heartrateData= {
            labels:labels,
            datasets: [{
               label: 'Heart rate',
                data: fakeHeartrate,
                borderWidth: 1
            }]
        }
     this.setState({data:heartrateData})
            })
    //    let fakeHeartrate = this.heartrate
    //    console.log(fakeHeartrate)
    //  let labels = []
    //     fakeHeartrate.map((data,index)=>{
    //         labels.push(index+1)
    //     })
    //  let   data= {
    //         labels:labels,
    //         datasets: [{
    //            label: 'Heart rate',
    //             data: fakeHeartrate,
    //             borderWidth: 1
    //         }]
    //     }
    // this.setState({data:data})
    }

    //get data from API and save on firebase
    addData = async () =>{
        var config = {
            headers: {'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2RlNRNU0iLCJhdWQiOiIyMkNWSjIiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyaHIgcnBybyIsImV4cCI6MTUzODc1NTc1OSwiaWF0IjoxNTM4MzIyMTY5fQ.SCCIg0SUQUWy4VGmypqI-zsdfGFGuB2VETEeF2b6_0s       '}
          };
         var start='12:20';
          var end='23:20';
          var mydate='2018-09-17'
          var x= 'https://api.fitbit.com/1/user/6FSQ5M/activities/heart/date/'+mydate+'/1d/1sec/time/'+start+'/'+end+'.json'
          //var x= 'https://api.fitbit.com/1/user/6FSQ5M/activities/heart/date/2018-09-17/1d/1sec/time/12:20/23:20.json'
      var data = await axios.get(x,config)
      
      this.setState({result:data})
           
      let arr = []
      for(var i = 0; i < this.state.result.data["activities-heart-intraday"].dataset.length; i++) {
        arr.push(this.state.result.data["activities-heart-intraday"].dataset[i].value)
      }
    
      //add to firebase
      await firebaseApp.database().ref('HealthProf').push({
        heartrate:arr
      })
    
    
    
    }
    addProfile = async() =>{
        var config = {
            headers: {'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2RlNRNU0iLCJhdWQiOiIyMkNWSjIiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyaHIgcnBybyIsImV4cCI6MTUzODc1NTc1OSwiaWF0IjoxNTM4MzIyMTY5fQ.SCCIg0SUQUWy4VGmypqI-zsdfGFGuB2VETEeF2b6_0s      '}
          };
          var profile = 'https://api.fitbit.com/1/user/6FSQ5M/profile.json'

      var data = await axios.get(profile,config)

      this.setState({result:data})
      let arr = []
      arr.push(this.state.result.data.user)

    //   for(var i = 0; i < this.state.result.data.user.length; i++) {
    //     arr.push(this.state.result.data.user[i].value)
    //   }
        //console.log(this.state.result.data.user)

        await firebaseApp.database().ref('Profile').push({
            profile:arr
          })
    }
    


componentDidMount(){
    this.setHeartRate()
    this.addData()
    this.addProfile()
}

  render() {
    return (
        // <div>sss</div>
        <Line data={this.state.data}
        options={{
            maintainAspectRatio:false
        }}
        />
    );
  }
}
export default Graph;