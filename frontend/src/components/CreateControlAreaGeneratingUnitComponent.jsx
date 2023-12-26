import React, { Component } from 'react'
import ControlAreaGeneratingUnitService from '../services/ControlAreaGeneratingUnitService';

class CreateControlAreaGeneratingUnitComponent extends Component {
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
            ControlAreaGeneratingUnitService.getControlAreaGeneratingUnitById(this.state.id).then( (res) =>{
                let controlAreaGeneratingUnit = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateControlAreaGeneratingUnit = (e) => {
        e.preventDefault();
        let controlAreaGeneratingUnit = {
                controlAreaGeneratingUnitId: this.state.id,
            };
        console.log('controlAreaGeneratingUnit => ' + JSON.stringify(controlAreaGeneratingUnit));

        // step 5
        if(this.state.id === '_add'){
            controlAreaGeneratingUnit.controlAreaGeneratingUnitId=''
            ControlAreaGeneratingUnitService.createControlAreaGeneratingUnit(controlAreaGeneratingUnit).then(res =>{
                this.props.history.push('/controlAreaGeneratingUnits');
            });
        }else{
            ControlAreaGeneratingUnitService.updateControlAreaGeneratingUnit(controlAreaGeneratingUnit).then( res => {
                this.props.history.push('/controlAreaGeneratingUnits');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/controlAreaGeneratingUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ControlAreaGeneratingUnit</h3>
        }else{
            return <h3 className="text-center">Update ControlAreaGeneratingUnit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateControlAreaGeneratingUnit}>Save</button>
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

export default CreateControlAreaGeneratingUnitComponent
