import React, { Component } from 'react'
import BasicIntervalScheduleService from '../services/BasicIntervalScheduleService'

class ListBasicIntervalScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                basicIntervalSchedules: []
        }
        this.addBasicIntervalSchedule = this.addBasicIntervalSchedule.bind(this);
        this.editBasicIntervalSchedule = this.editBasicIntervalSchedule.bind(this);
        this.deleteBasicIntervalSchedule = this.deleteBasicIntervalSchedule.bind(this);
    }

    deleteBasicIntervalSchedule(id){
        BasicIntervalScheduleService.deleteBasicIntervalSchedule(id).then( res => {
            this.setState({basicIntervalSchedules: this.state.basicIntervalSchedules.filter(basicIntervalSchedule => basicIntervalSchedule.basicIntervalScheduleId !== id)});
        });
    }
    viewBasicIntervalSchedule(id){
        this.props.history.push(`/view-basicIntervalSchedule/${id}`);
    }
    editBasicIntervalSchedule(id){
        this.props.history.push(`/add-basicIntervalSchedule/${id}`);
    }

    componentDidMount(){
        BasicIntervalScheduleService.getBasicIntervalSchedules().then((res) => {
            this.setState({ basicIntervalSchedules: res.data});
        });
    }

    addBasicIntervalSchedule(){
        this.props.history.push('/add-basicIntervalSchedule/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">BasicIntervalSchedule List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addBasicIntervalSchedule}> Add BasicIntervalSchedule</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> StartTime </th>
                                    <th> Value1Unit </th>
                                    <th> Value2Unit </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.basicIntervalSchedules.map(
                                        basicIntervalSchedule => 
                                        <tr key = {basicIntervalSchedule.basicIntervalScheduleId}>
                                             <td> { basicIntervalSchedule.startTime } </td>
                                             <td> { basicIntervalSchedule.value1Unit } </td>
                                             <td> { basicIntervalSchedule.value2Unit } </td>
                                             <td>
                                                 <button onClick={ () => this.editBasicIntervalSchedule(basicIntervalSchedule.basicIntervalScheduleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBasicIntervalSchedule(basicIntervalSchedule.basicIntervalScheduleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewBasicIntervalSchedule(basicIntervalSchedule.basicIntervalScheduleId)} className="btn btn-info btn-sm">View </button>
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

export default ListBasicIntervalScheduleComponent
