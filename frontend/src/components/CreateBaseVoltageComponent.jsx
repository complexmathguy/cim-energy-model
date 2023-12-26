import React, { Component } from 'react'
import BaseVoltageService from '../services/BaseVoltageService';

class CreateBaseVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                nominalVoltage: ''
        }
        this.changenominalVoltageHandler = this.changenominalVoltageHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            BaseVoltageService.getBaseVoltageById(this.state.id).then( (res) =>{
                let baseVoltage = res.data;
                this.setState({
                    nominalVoltage: baseVoltage.nominalVoltage
                });
            });
        }        
    }
    saveOrUpdateBaseVoltage = (e) => {
        e.preventDefault();
        let baseVoltage = {
                baseVoltageId: this.state.id,
                nominalVoltage: this.state.nominalVoltage
            };
        console.log('baseVoltage => ' + JSON.stringify(baseVoltage));

        // step 5
        if(this.state.id === '_add'){
            baseVoltage.baseVoltageId=''
            BaseVoltageService.createBaseVoltage(baseVoltage).then(res =>{
                this.props.history.push('/baseVoltages');
            });
        }else{
            BaseVoltageService.updateBaseVoltage(baseVoltage).then( res => {
                this.props.history.push('/baseVoltages');
            });
        }
    }
    
    changenominalVoltageHandler= (event) => {
        this.setState({nominalVoltage: event.target.value});
    }

    cancel(){
        this.props.history.push('/baseVoltages');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add BaseVoltage</h3>
        }else{
            return <h3 className="text-center">Update BaseVoltage</h3>
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
                                            <label> nominalVoltage: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBaseVoltage}>Save</button>
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

export default CreateBaseVoltageComponent
