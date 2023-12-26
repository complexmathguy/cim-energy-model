import React, { Component } from 'react'
import TapScheduleService from '../services/TapScheduleService'

class ListTapScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                tapSchedules: []
        }
        this.addTapSchedule = this.addTapSchedule.bind(this);
        this.editTapSchedule = this.editTapSchedule.bind(this);
        this.deleteTapSchedule = this.deleteTapSchedule.bind(this);
    }

    deleteTapSchedule(id){
        TapScheduleService.deleteTapSchedule(id).then( res => {
            this.setState({tapSchedules: this.state.tapSchedules.filter(tapSchedule => tapSchedule.tapScheduleId !== id)});
        });
    }
    viewTapSchedule(id){
        this.props.history.push(`/view-tapSchedule/${id}`);
    }
    editTapSchedule(id){
        this.props.history.push(`/add-tapSchedule/${id}`);
    }

    componentDidMount(){
        TapScheduleService.getTapSchedules().then((res) => {
            this.setState({ tapSchedules: res.data});
        });
    }

    addTapSchedule(){
        this.props.history.push('/add-tapSchedule/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TapSchedule List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTapSchedule}> Add TapSchedule</button>
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
                                    this.state.tapSchedules.map(
                                        tapSchedule => 
                                        <tr key = {tapSchedule.tapScheduleId}>
                                             <td>
                                                 <button onClick={ () => this.editTapSchedule(tapSchedule.tapScheduleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTapSchedule(tapSchedule.tapScheduleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTapSchedule(tapSchedule.tapScheduleId)} className="btn btn-info btn-sm">View </button>
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

export default ListTapScheduleComponent
