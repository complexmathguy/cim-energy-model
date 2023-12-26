import React, { Component } from 'react'
import ConformLoadScheduleService from '../services/ConformLoadScheduleService';

class CreateConformLoadScheduleComponent extends Component {
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
            ConformLoadScheduleService.getConformLoadScheduleById(this.state.id).then( (res) =>{
                let conformLoadSchedule = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateConformLoadSchedule = (e) => {
        e.preventDefault();
        let conformLoadSchedule = {
                conformLoadScheduleId: this.state.id,
            };
        console.log('conformLoadSchedule => ' + JSON.stringify(conformLoadSchedule));

        // step 5
        if(this.state.id === '_add'){
            conformLoadSchedule.conformLoadScheduleId=''
            ConformLoadScheduleService.createConformLoadSchedule(conformLoadSchedule).then(res =>{
                this.props.history.push('/conformLoadSchedules');
            });
        }else{
            ConformLoadScheduleService.updateConformLoadSchedule(conformLoadSchedule).then( res => {
                this.props.history.push('/conformLoadSchedules');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/conformLoadSchedules');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ConformLoadSchedule</h3>
        }else{
            return <h3 className="text-center">Update ConformLoadSchedule</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateConformLoadSchedule}>Save</button>
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

export default CreateConformLoadScheduleComponent
