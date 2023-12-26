import React, { Component } from 'react'
import SeasonDayTypeScheduleService from '../services/SeasonDayTypeScheduleService'

class ListSeasonDayTypeScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                seasonDayTypeSchedules: []
        }
        this.addSeasonDayTypeSchedule = this.addSeasonDayTypeSchedule.bind(this);
        this.editSeasonDayTypeSchedule = this.editSeasonDayTypeSchedule.bind(this);
        this.deleteSeasonDayTypeSchedule = this.deleteSeasonDayTypeSchedule.bind(this);
    }

    deleteSeasonDayTypeSchedule(id){
        SeasonDayTypeScheduleService.deleteSeasonDayTypeSchedule(id).then( res => {
            this.setState({seasonDayTypeSchedules: this.state.seasonDayTypeSchedules.filter(seasonDayTypeSchedule => seasonDayTypeSchedule.seasonDayTypeScheduleId !== id)});
        });
    }
    viewSeasonDayTypeSchedule(id){
        this.props.history.push(`/view-seasonDayTypeSchedule/${id}`);
    }
    editSeasonDayTypeSchedule(id){
        this.props.history.push(`/add-seasonDayTypeSchedule/${id}`);
    }

    componentDidMount(){
        SeasonDayTypeScheduleService.getSeasonDayTypeSchedules().then((res) => {
            this.setState({ seasonDayTypeSchedules: res.data});
        });
    }

    addSeasonDayTypeSchedule(){
        this.props.history.push('/add-seasonDayTypeSchedule/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SeasonDayTypeSchedule List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSeasonDayTypeSchedule}> Add SeasonDayTypeSchedule</button>
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
                                    this.state.seasonDayTypeSchedules.map(
                                        seasonDayTypeSchedule => 
                                        <tr key = {seasonDayTypeSchedule.seasonDayTypeScheduleId}>
                                             <td>
                                                 <button onClick={ () => this.editSeasonDayTypeSchedule(seasonDayTypeSchedule.seasonDayTypeScheduleId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSeasonDayTypeSchedule(seasonDayTypeSchedule.seasonDayTypeScheduleId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSeasonDayTypeSchedule(seasonDayTypeSchedule.seasonDayTypeScheduleId)} className="btn btn-info btn-sm">View </button>
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

export default ListSeasonDayTypeScheduleComponent
