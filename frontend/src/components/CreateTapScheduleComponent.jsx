import React, { Component } from 'react'
import TapScheduleService from '../services/TapScheduleService';

class CreateTapScheduleComponent extends Component {
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
            TapScheduleService.getTapScheduleById(this.state.id).then( (res) =>{
                let tapSchedule = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTapSchedule = (e) => {
        e.preventDefault();
        let tapSchedule = {
                tapScheduleId: this.state.id,
            };
        console.log('tapSchedule => ' + JSON.stringify(tapSchedule));

        // step 5
        if(this.state.id === '_add'){
            tapSchedule.tapScheduleId=''
            TapScheduleService.createTapSchedule(tapSchedule).then(res =>{
                this.props.history.push('/tapSchedules');
            });
        }else{
            TapScheduleService.updateTapSchedule(tapSchedule).then( res => {
                this.props.history.push('/tapSchedules');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/tapSchedules');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TapSchedule</h3>
        }else{
            return <h3 className="text-center">Update TapSchedule</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTapSchedule}>Save</button>
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

export default CreateTapScheduleComponent
