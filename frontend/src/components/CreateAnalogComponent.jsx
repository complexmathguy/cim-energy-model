import React, { Component } from 'react'
import AnalogService from '../services/AnalogService';

class CreateAnalogComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                positiveFlowIn: ''
        }
        this.changepositiveFlowInHandler = this.changepositiveFlowInHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            AnalogService.getAnalogById(this.state.id).then( (res) =>{
                let analog = res.data;
                this.setState({
                    positiveFlowIn: analog.positiveFlowIn
                });
            });
        }        
    }
    saveOrUpdateAnalog = (e) => {
        e.preventDefault();
        let analog = {
                analogId: this.state.id,
                positiveFlowIn: this.state.positiveFlowIn
            };
        console.log('analog => ' + JSON.stringify(analog));

        // step 5
        if(this.state.id === '_add'){
            analog.analogId=''
            AnalogService.createAnalog(analog).then(res =>{
                this.props.history.push('/analogs');
            });
        }else{
            AnalogService.updateAnalog(analog).then( res => {
                this.props.history.push('/analogs');
            });
        }
    }
    
    changepositiveFlowInHandler= (event) => {
        this.setState({positiveFlowIn: event.target.value});
    }

    cancel(){
        this.props.history.push('/analogs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Analog</h3>
        }else{
            return <h3 className="text-center">Update Analog</h3>
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
                                            <label> positiveFlowIn: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAnalog}>Save</button>
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

export default CreateAnalogComponent
