import React, { Component } from 'react'
import RegulationScheduleService from '../services/RegulationScheduleService'

class ListRegulationScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                regulationSchedules: []
        }
        this.addRegulationSchedule = this.addRegulationSchedule.bind(this);
        this.editRegulationSchedule = this.editRegulationSchedule.bind(this);
        this.deleteRegulationSchedule = this.deleteRegulationSchedule.bind(this);
    }

    deleteRegulationSchedule(id){
        RegulationScheduleService.deleteRegulationSchedule(id).then( res => {
            this.setState({regulationSchedules: this.state.regulationSchedules.filter(regulationSchedule => regulationSchedule.regulationScheduleId !== id)});
        });
    }
    viewRegulationSchedule(id){
        this.props.history.push(`/view-regulationSchedule/${id}`);
    }
    editRegulationSchedule(id){
        this.props.history.push(`/add-regulationSchedule/${id}`);
    }

    componentDidMount(){
        RegulationScheduleService.getRegulationSchedules().then((res) => {
            this.setState({ regulationSchedules: res.data});
        });
    }

    addRegulationSchedule(){
        this.props.history.push('/add-regulationSchedule/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RegulationSchedule List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRegulationSchedule}> Add RegulationSchedule</button>
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
                                    this.state.regulationSchedules.map(
                                        regulationSchedule => 
                                        <tr key = {regulationSchedule.regulationScheduleId}>
                                             <td>
                                                 <button onClick={ () => this.editRegulationSchedule(regulationSchedule.regulationScheduleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRegulationSchedule(regulationSchedule.regulationScheduleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRegulationSchedule(regulationSchedule.regulationScheduleId)} className="btn btn-info btn-sm">View </button>
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

export default ListRegulationScheduleComponent
