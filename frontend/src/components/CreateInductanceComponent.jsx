import React, { Component } from 'react'
import InductanceService from '../services/InductanceService';

class CreateInductanceComponent extends Component {
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
            InductanceService.getInductanceById(this.state.id).then( (res) =>{
                let inductance = res.data;
                this.setState({
                    multiplier: inductance.multiplier,
                    unit: inductance.unit,
                    value: inductance.value
                });
            });
        }        
    }
    saveOrUpdateInductance = (e) => {
        e.preventDefault();
        let inductance = {
                inductanceId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('inductance => ' + JSON.stringify(inductance));

        // step 5
        if(this.state.id === '_add'){
            inductance.inductanceId=''
            InductanceService.createInductance(inductance).then(res =>{
                this.props.history.push('/inductances');
            });
        }else{
            InductanceService.updateInductance(inductance).then( res => {
                this.props.history.push('/inductances');
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
        this.props.history.push('/inductances');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Inductance</h3>
        }else{
            return <h3 className="text-center">Update Inductance</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateInductance}>Save</button>
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

export default CreateInductanceComponent
