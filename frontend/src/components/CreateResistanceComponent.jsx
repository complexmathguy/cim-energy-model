import React, { Component } from 'react'
import ResistanceService from '../services/ResistanceService';

class CreateResistanceComponent extends Component {
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
            ResistanceService.getResistanceById(this.state.id).then( (res) =>{
                let resistance = res.data;
                this.setState({
                    multiplier: resistance.multiplier,
                    unit: resistance.unit,
                    value: resistance.value
                });
            });
        }        
    }
    saveOrUpdateResistance = (e) => {
        e.preventDefault();
        let resistance = {
                resistanceId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('resistance => ' + JSON.stringify(resistance));

        // step 5
        if(this.state.id === '_add'){
            resistance.resistanceId=''
            ResistanceService.createResistance(resistance).then(res =>{
                this.props.history.push('/resistances');
            });
        }else{
            ResistanceService.updateResistance(resistance).then( res => {
                this.props.history.push('/resistances');
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
        this.props.history.push('/resistances');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Resistance</h3>
        }else{
            return <h3 className="text-center">Update Resistance</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateResistance}>Save</button>
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

export default CreateResistanceComponent
