import React, { Component } from 'react'
import MonthDayService from '../services/MonthDayService';

class CreateMonthDayComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            MonthDayService.getMonthDayById(this.state.id).then( (res) =>{
                let monthDay = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateMonthDay = (e) => {
        e.preventDefault();
        let monthDay = {
                monthDayId: this.state.id,
            };
        console.log('monthDay => ' + JSON.stringify(monthDay));

        // step 5
        if(this.state.id === '_add'){
            monthDay.monthDayId=''
            MonthDayService.createMonthDay(monthDay).then(res =>{
                this.props.history.push('/monthDays');
            });
        }else{
            MonthDayService.updateMonthDay(monthDay).then( res => {
                this.props.history.push('/monthDays');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/monthDays');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MonthDay</h3>
        }else{
            return <h3 className="text-center">Update MonthDay</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMonthDay}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateMonthDayComponent
