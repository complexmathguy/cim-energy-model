import React, { Component } from 'react'
import SwitchScheduleService from '../services/SwitchScheduleService';

class CreateSwitchScheduleComponent extends Component {
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
            SwitchScheduleService.getSwitchScheduleById(this.state.id).then( (res) =>{
                let switchSchedule = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSwitchSchedule = (e) => {
        e.preventDefault();
        let switchSchedule = {
                switchScheduleId: this.state.id,
            };
        console.log('switchSchedule => ' + JSON.stringify(switchSchedule));

        // step 5
        if(this.state.id === '_add'){
            switchSchedule.switchScheduleId=''
            SwitchScheduleService.createSwitchSchedule(switchSchedule).then(res =>{
                this.props.history.push('/switchSchedules');
            });
        }else{
            SwitchScheduleService.updateSwitchSchedule(switchSchedule).then( res => {
                this.props.history.push('/switchSchedules');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/switchSchedules');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SwitchSchedule</h3>
        }else{
            return <h3 className="text-center">Update SwitchSchedule</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSwitchSchedule}>Save</button>
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

export default CreateSwitchScheduleComponent
