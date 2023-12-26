import React, { Component } from 'react'
import RegularIntervalScheduleService from '../services/RegularIntervalScheduleService'

class ListRegularIntervalScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                regularIntervalSchedules: []
        }
        this.addRegularIntervalSchedule = this.addRegularIntervalSchedule.bind(this);
        this.editRegularIntervalSchedule = this.editRegularIntervalSchedule.bind(this);
        this.deleteRegularIntervalSchedule = this.deleteRegularIntervalSchedule.bind(this);
    }

    deleteRegularIntervalSchedule(id){
        RegularIntervalScheduleService.deleteRegularIntervalSchedule(id).then( res => {
            this.setState({regularIntervalSchedules: this.state.regularIntervalSchedules.filter(regularIntervalSchedule => regularIntervalSchedule.regularIntervalScheduleId !== id)});
        });
    }
    viewRegularIntervalSchedule(id){
        this.props.history.push(`/view-regularIntervalSchedule/${id}`);
    }
    editRegularIntervalSchedule(id){
        this.props.history.push(`/add-regularIntervalSchedule/${id}`);
    }

    componentDidMount(){
        RegularIntervalScheduleService.getRegularIntervalSchedules().then((res) => {
            this.setState({ regularIntervalSchedules: res.data});
        });
    }

    addRegularIntervalSchedule(){
        this.props.history.push('/add-regularIntervalSchedule/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RegularIntervalSchedule List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRegularIntervalSchedule}> Add RegularIntervalSchedule</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> EndTime </th>
                                    <th> TimeStep </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.regularIntervalSchedules.map(
                                        regularIntervalSchedule => 
                                        <tr key = {regularIntervalSchedule.regularIntervalScheduleId}>
                                             <td> { regularIntervalSchedule.endTime } </td>
                                             <td> { regularIntervalSchedule.timeStep } </td>
                                             <td>
                                                 <button onClick={ () => this.editRegularIntervalSchedule(regularIntervalSchedule.regularIntervalScheduleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRegularIntervalSchedule(regularIntervalSchedule.regularIntervalScheduleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRegularIntervalSchedule(regularIntervalSchedule.regularIntervalScheduleId)} className="btn btn-info btn-sm">View </button>
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

export default ListRegularIntervalScheduleComponent
