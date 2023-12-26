import React, { Component } from 'react'
import MonthDayService from '../services/MonthDayService'

class ListMonthDayComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                monthDays: []
        }
        this.addMonthDay = this.addMonthDay.bind(this);
        this.editMonthDay = this.editMonthDay.bind(this);
        this.deleteMonthDay = this.deleteMonthDay.bind(this);
    }

    deleteMonthDay(id){
        MonthDayService.deleteMonthDay(id).then( res => {
            this.setState({monthDays: this.state.monthDays.filter(monthDay => monthDay.monthDayId !== id)});
        });
    }
    viewMonthDay(id){
        this.props.history.push(`/view-monthDay/${id}`);
    }
    editMonthDay(id){
        this.props.history.push(`/add-monthDay/${id}`);
    }

    componentDidMount(){
        MonthDayService.getMonthDays().then((res) => {
            this.setState({ monthDays: res.data});
        });
    }

    addMonthDay(){
        this.props.history.push('/add-monthDay/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MonthDay List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMonthDay}> Add MonthDay</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.monthDays.map(
                                        monthDay => 
                                        <tr key = {monthDay.monthDayId}>
                                             <td>
                                                 <button onClick={ () => this.editMonthDay(monthDay.monthDayId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMonthDay(monthDay.monthDayId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMonthDay(monthDay.monthDayId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListMonthDayComponent
