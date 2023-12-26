import React, { Component } from 'react'
import SeasonDayTypeScheduleService from '../services/SeasonDayTypeScheduleService';

class UpdateSeasonDayTypeScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSeasonDayTypeSchedule = this.updateSeasonDayTypeSchedule.bind(this);

    }

    componentDidMount(){
        SeasonDayTypeScheduleService.getSeasonDayTypeScheduleById(this.state.id).then( (res) =>{
            let seasonDayTypeSchedule = res.data;
            this.setState({
            });
        });
    }

    updateSeasonDayTypeSchedule = (e) => {
        e.preventDefault();
        let seasonDayTypeSchedule = {
            seasonDayTypeScheduleId: this.state.id,
        };
        console.log('seasonDayTypeSchedule => ' + JSON.stringify(seasonDayTypeSchedule));
        console.log('id => ' + JSON.stringify(this.state.id));
        SeasonDayTypeScheduleService.updateSeasonDayTypeSchedule(seasonDayTypeSchedule).then( res => {
            this.props.history.push('/seasonDayTypeSchedules');
        });
    }


    cancel(){
        this.props.history.push('/seasonDayTypeSchedules');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SeasonDayTypeSchedule</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSeasonDayTypeSchedule}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateSeasonDayTypeScheduleComponent
