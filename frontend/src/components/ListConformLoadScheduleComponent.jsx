import React, { Component } from 'react'
import ConformLoadScheduleService from '../services/ConformLoadScheduleService'

class ListConformLoadScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                conformLoadSchedules: []
        }
        this.addConformLoadSchedule = this.addConformLoadSchedule.bind(this);
        this.editConformLoadSchedule = this.editConformLoadSchedule.bind(this);
        this.deleteConformLoadSchedule = this.deleteConformLoadSchedule.bind(this);
    }

    deleteConformLoadSchedule(id){
        ConformLoadScheduleService.deleteConformLoadSchedule(id).then( res => {
            this.setState({conformLoadSchedules: this.state.conformLoadSchedules.filter(conformLoadSchedule => conformLoadSchedule.conformLoadScheduleId !== id)});
        });
    }
    viewConformLoadSchedule(id){
        this.props.history.push(`/view-conformLoadSchedule/${id}`);
    }
    editConformLoadSchedule(id){
        this.props.history.push(`/add-conformLoadSchedule/${id}`);
    }

    componentDidMount(){
        ConformLoadScheduleService.getConformLoadSchedules().then((res) => {
            this.setState({ conformLoadSchedules: res.data});
        });
    }

    addConformLoadSchedule(){
        this.props.history.push('/add-conformLoadSchedule/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ConformLoadSchedule List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConformLoadSchedule}> Add ConformLoadSchedule</button>
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
                                    this.state.conformLoadSchedules.map(
                                        conformLoadSchedule => 
                                        <tr key = {conformLoadSchedule.conformLoadScheduleId}>
                                             <td>
                                                 <button onClick={ () => this.editConformLoadSchedule(conformLoadSchedule.conformLoadScheduleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConformLoadSchedule(conformLoadSchedule.conformLoadScheduleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConformLoadSchedule(conformLoadSchedule.conformLoadScheduleId)} className="btn btn-info btn-sm">View </button>
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

export default ListConformLoadScheduleComponent
