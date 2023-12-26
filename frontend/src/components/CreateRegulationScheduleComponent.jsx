import React, { Component } from 'react'
import RegulationScheduleService from '../services/RegulationScheduleService';

class CreateRegulationScheduleComponent extends Component {
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
            RegulationScheduleService.getRegulationScheduleById(this.state.id).then( (res) =>{
                let regulationSchedule = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateRegulationSchedule = (e) => {
        e.preventDefault();
        let regulationSchedule = {
                regulationScheduleId: this.state.id,
            };
        console.log('regulationSchedule => ' + JSON.stringify(regulationSchedule));

        // step 5
        if(this.state.id === '_add'){
            regulationSchedule.regulationScheduleId=''
            RegulationScheduleService.createRegulationSchedule(regulationSchedule).then(res =>{
                this.props.history.push('/regulationSchedules');
            });
        }else{
            RegulationScheduleService.updateRegulationSchedule(regulationSchedule).then( res => {
                this.props.history.push('/regulationSchedules');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/regulationSchedules');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RegulationSchedule</h3>
        }else{
            return <h3 className="text-center">Update RegulationSchedule</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRegulationSchedule}>Save</button>
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

export default CreateRegulationScheduleComponent
