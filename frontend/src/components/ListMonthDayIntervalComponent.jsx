import React, { Component } from 'react'
import MonthDayIntervalService from '../services/MonthDayIntervalService'

class ListMonthDayIntervalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                monthDayIntervals: []
        }
        this.addMonthDayInterval = this.addMonthDayInterval.bind(this);
        this.editMonthDayInterval = this.editMonthDayInterval.bind(this);
        this.deleteMonthDayInterval = this.deleteMonthDayInterval.bind(this);
    }

    deleteMonthDayInterval(id){
        MonthDayIntervalService.deleteMonthDayInterval(id).then( res => {
            this.setState({monthDayIntervals: this.state.monthDayIntervals.filter(monthDayInterval => monthDayInterval.monthDayIntervalId !== id)});
        });
    }
    viewMonthDayInterval(id){
        this.props.history.push(`/view-monthDayInterval/${id}`);
    }
    editMonthDayInterval(id){
        this.props.history.push(`/add-monthDayInterval/${id}`);
    }

    componentDidMount(){
        MonthDayIntervalService.getMonthDayIntervals().then((res) => {
            this.setState({ monthDayIntervals: res.data});
        });
    }

    addMonthDayInterval(){
        this.props.history.push('/add-monthDayInterval/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MonthDayInterval List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMonthDayInterval}> Add MonthDayInterval</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> End </th>
                                    <th> Start </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.monthDayIntervals.map(
                                        monthDayInterval => 
                                        <tr key = {monthDayInterval.monthDayIntervalId}>
                                             <td> { monthDayInterval.end } </td>
                                             <td> { monthDayInterval.start } </td>
                                             <td>
                                                 <button onClick={ () => this.editMonthDayInterval(monthDayInterval.monthDayIntervalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMonthDayInterval(monthDayInterval.monthDayIntervalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMonthDayInterval(monthDayInterval.monthDayIntervalId)} className="btn btn-info btn-sm">View </button>
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

export default ListMonthDayIntervalComponent
