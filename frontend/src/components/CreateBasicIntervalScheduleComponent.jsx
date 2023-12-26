import React, { Component } from 'react'
import BasicIntervalScheduleService from '../services/BasicIntervalScheduleService';

class CreateBasicIntervalScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                startTime: '',
                value1Unit: '',
                value2Unit: ''
        }
        this.changestartTimeHandler = this.changestartTimeHandler.bind(this);
        this.changevalue1UnitHandler = this.changevalue1UnitHandler.bind(this);
        this.changevalue2UnitHandler = this.changevalue2UnitHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            BasicIntervalScheduleService.getBasicIntervalScheduleById(this.state.id).then( (res) =>{
                let basicIntervalSchedule = res.data;
                this.setState({
                    startTime: basicIntervalSchedule.startTime,
                    value1Unit: basicIntervalSchedule.value1Unit,
                    value2Unit: basicIntervalSchedule.value2Unit
                });
            });
        }        
    }
    saveOrUpdateBasicIntervalSchedule = (e) => {
        e.preventDefault();
        let basicIntervalSchedule = {
                basicIntervalScheduleId: this.state.id,
                startTime: this.state.startTime,
                value1Unit: this.state.value1Unit,
                value2Unit: this.state.value2Unit
            };
        console.log('basicIntervalSchedule => ' + JSON.stringify(basicIntervalSchedule));

        // step 5
        if(this.state.id === '_add'){
            basicIntervalSchedule.basicIntervalScheduleId=''
            BasicIntervalScheduleService.createBasicIntervalSchedule(basicIntervalSchedule).then(res =>{
                this.props.history.push('/basicIntervalSchedules');
            });
        }else{
            BasicIntervalScheduleService.updateBasicIntervalSchedule(basicIntervalSchedule).then( res => {
                this.props.history.push('/basicIntervalSchedules');
            });
        }
    }
    
    changestartTimeHandler= (event) => {
        this.setState({startTime: event.target.value});
    }
    changevalue1UnitHandler= (event) => {
        this.setState({value1Unit: event.target.value});
    }
    changevalue2UnitHandler= (event) => {
        this.setState({value2Unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/basicIntervalSchedules');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add BasicIntervalSchedule</h3>
        }else{
            return <h3 className="text-center">Update BasicIntervalSchedule</h3>
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
                                            <label> startTime: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value1Unit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value2Unit: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBasicIntervalSchedule}>Save</button>
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

export default CreateBasicIntervalScheduleComponent
