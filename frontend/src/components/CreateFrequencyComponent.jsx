import React, { Component } from 'react'
import FrequencyService from '../services/FrequencyService';

class CreateFrequencyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            FrequencyService.getFrequencyById(this.state.id).then( (res) =>{
                let frequency = res.data;
                this.setState({
                    multiplier: frequency.multiplier,
                    unit: frequency.unit,
                    value: frequency.value
                });
            });
        }        
    }
    saveOrUpdateFrequency = (e) => {
        e.preventDefault();
        let frequency = {
                frequencyId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('frequency => ' + JSON.stringify(frequency));

        // step 5
        if(this.state.id === '_add'){
            frequency.frequencyId=''
            FrequencyService.createFrequency(frequency).then(res =>{
                this.props.history.push('/frequencys');
            });
        }else{
            FrequencyService.updateFrequency(frequency).then( res => {
                this.props.history.push('/frequencys');
            });
        }
    }
    
    changemultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeunitHandler= (event) => {
        this.setState({unit: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/frequencys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Frequency</h3>
        }else{
            return <h3 className="text-center">Update Frequency</h3>
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
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateFrequency}>Save</button>
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

export default CreateFrequencyComponent
