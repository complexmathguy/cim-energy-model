import React, { Component } from 'react'
import NonConformLoadScheduleService from '../services/NonConformLoadScheduleService'

class ListNonConformLoadScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                nonConformLoadSchedules: []
        }
        this.addNonConformLoadSchedule = this.addNonConformLoadSchedule.bind(this);
        this.editNonConformLoadSchedule = this.editNonConformLoadSchedule.bind(this);
        this.deleteNonConformLoadSchedule = this.deleteNonConformLoadSchedule.bind(this);
    }

    deleteNonConformLoadSchedule(id){
        NonConformLoadScheduleService.deleteNonConformLoadSchedule(id).then( res => {
            this.setState({nonConformLoadSchedules: this.state.nonConformLoadSchedules.filter(nonConformLoadSchedule => nonConformLoadSchedule.nonConformLoadScheduleId !== id)});
        });
    }
    viewNonConformLoadSchedule(id){
        this.props.history.push(`/view-nonConformLoadSchedule/${id}`);
    }
    editNonConformLoadSchedule(id){
        this.props.history.push(`/add-nonConformLoadSchedule/${id}`);
    }

    componentDidMount(){
        NonConformLoadScheduleService.getNonConformLoadSchedules().then((res) => {
            this.setState({ nonConformLoadSchedules: res.data});
        });
    }

    addNonConformLoadSchedule(){
        this.props.history.push('/add-nonConformLoadSchedule/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">NonConformLoadSchedule List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addNonConformLoadSchedule}> Add NonConformLoadSchedule</button>
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
                                    this.state.nonConformLoadSchedules.map(
                                        nonConformLoadSchedule => 
                                        <tr key = {nonConformLoadSchedule.nonConformLoadScheduleId}>
                                             <td>
                                                 <button onClick={ () => this.editNonConformLoadSchedule(nonConformLoadSchedule.nonConformLoadScheduleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteNonConformLoadSchedule(nonConformLoadSchedule.nonConformLoadScheduleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewNonConformLoadSchedule(nonConformLoadSchedule.nonConformLoadScheduleId)} className="btn btn-info btn-sm">View </button>
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

export default ListNonConformLoadScheduleComponent
