import React, { Component } from 'react'
import SwitchScheduleService from '../services/SwitchScheduleService'

class ListSwitchScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                switchSchedules: []
        }
        this.addSwitchSchedule = this.addSwitchSchedule.bind(this);
        this.editSwitchSchedule = this.editSwitchSchedule.bind(this);
        this.deleteSwitchSchedule = this.deleteSwitchSchedule.bind(this);
    }

    deleteSwitchSchedule(id){
        SwitchScheduleService.deleteSwitchSchedule(id).then( res => {
            this.setState({switchSchedules: this.state.switchSchedules.filter(switchSchedule => switchSchedule.switchScheduleId !== id)});
        });
    }
    viewSwitchSchedule(id){
        this.props.history.push(`/view-switchSchedule/${id}`);
    }
    editSwitchSchedule(id){
        this.props.history.push(`/add-switchSchedule/${id}`);
    }

    componentDidMount(){
        SwitchScheduleService.getSwitchSchedules().then((res) => {
            this.setState({ switchSchedules: res.data});
        });
    }

    addSwitchSchedule(){
        this.props.history.push('/add-switchSchedule/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SwitchSchedule List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSwitchSchedule}> Add SwitchSchedule</button>
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
                                    this.state.switchSchedules.map(
                                        switchSchedule => 
                                        <tr key = {switchSchedule.switchScheduleId}>
                                             <td>
                                                 <button onClick={ () => this.editSwitchSchedule(switchSchedule.switchScheduleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSwitchSchedule(switchSchedule.switchScheduleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSwitchSchedule(switchSchedule.switchScheduleId)} className="btn btn-info btn-sm">View </button>
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

export default ListSwitchScheduleComponent
