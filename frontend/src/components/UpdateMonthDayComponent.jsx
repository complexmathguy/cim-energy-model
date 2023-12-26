import React, { Component } from 'react'
import MonthDayService from '../services/MonthDayService';

class UpdateMonthDayComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateMonthDay = this.updateMonthDay.bind(this);

    }

    componentDidMount(){
        MonthDayService.getMonthDayById(this.state.id).then( (res) =>{
            let monthDay = res.data;
            this.setState({
            });
        });
    }

    updateMonthDay = (e) => {
        e.preventDefault();
        let monthDay = {
            monthDayId: this.state.id,
        };
        console.log('monthDay => ' + JSON.stringify(monthDay));
        console.log('id => ' + JSON.stringify(this.state.id));
        MonthDayService.updateMonthDay(monthDay).then( res => {
            this.props.history.push('/monthDays');
        });
    }


    cancel(){
        this.props.history.push('/monthDays');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MonthDay</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMonthDay}>Save</button>
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

export default UpdateMonthDayComponent
