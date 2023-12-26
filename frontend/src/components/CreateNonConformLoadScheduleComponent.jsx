import React, { Component } from 'react'
import NonConformLoadScheduleService from '../services/NonConformLoadScheduleService';

class CreateNonConformLoadScheduleComponent extends Component {
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
            NonConformLoadScheduleService.getNonConformLoadScheduleById(this.state.id).then( (res) =>{
                let nonConformLoadSchedule = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateNonConformLoadSchedule = (e) => {
        e.preventDefault();
        let nonConformLoadSchedule = {
                nonConformLoadScheduleId: this.state.id,
            };
        console.log('nonConformLoadSchedule => ' + JSON.stringify(nonConformLoadSchedule));

        // step 5
        if(this.state.id === '_add'){
            nonConformLoadSchedule.nonConformLoadScheduleId=''
            NonConformLoadScheduleService.createNonConformLoadSchedule(nonConformLoadSchedule).then(res =>{
                this.props.history.push('/nonConformLoadSchedules');
            });
        }else{
            NonConformLoadScheduleService.updateNonConformLoadSchedule(nonConformLoadSchedule).then( res => {
                this.props.history.push('/nonConformLoadSchedules');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/nonConformLoadSchedules');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add NonConformLoadSchedule</h3>
        }else{
            return <h3 className="text-center">Update NonConformLoadSchedule</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateNonConformLoadSchedule}>Save</button>
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

export default CreateNonConformLoadScheduleComponent
