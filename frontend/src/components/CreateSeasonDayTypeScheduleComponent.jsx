import React, { Component } from 'react'
import SeasonDayTypeScheduleService from '../services/SeasonDayTypeScheduleService';

class CreateSeasonDayTypeScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SeasonDayTypeScheduleService.getSeasonDayTypeScheduleById(this.state.id).then( (res) =>{
                let seasonDayTypeSchedule = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSeasonDayTypeSchedule = (e) => {
        e.preventDefault();
        let seasonDayTypeSchedule = {
                seasonDayTypeScheduleId: this.state.id,
            };
        console.log('seasonDayTypeSchedule => ' + JSON.stringify(seasonDayTypeSchedule));

        // step 5
        if(this.state.id === '_add'){
            seasonDayTypeSchedule.seasonDayTypeScheduleId=''
            SeasonDayTypeScheduleService.createSeasonDayTypeSchedule(seasonDayTypeSchedule).then(res =>{
                this.props.history.push('/seasonDayTypeSchedules');
            });
        }else{
            SeasonDayTypeScheduleService.updateSeasonDayTypeSchedule(seasonDayTypeSchedule).then( res => {
                this.props.history.push('/seasonDayTypeSchedules');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/seasonDayTypeSchedules');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SeasonDayTypeSchedule</h3>
        }else{
            return <h3 className="text-center">Update SeasonDayTypeSchedule</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSeasonDayTypeSchedule}>Save</button>
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

export default CreateSeasonDayTypeScheduleComponent
