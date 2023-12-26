import React, { Component } from 'react'
import ReactivePowerService from '../services/ReactivePowerService';

class CreateReactivePowerComponent extends Component {
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
            ReactivePowerService.getReactivePowerById(this.state.id).then( (res) =>{
                let reactivePower = res.data;
                this.setState({
                    multiplier: reactivePower.multiplier,
                    unit: reactivePower.unit,
                    value: reactivePower.value
                });
            });
        }        
    }
    saveOrUpdateReactivePower = (e) => {
        e.preventDefault();
        let reactivePower = {
                reactivePowerId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('reactivePower => ' + JSON.stringify(reactivePower));

        // step 5
        if(this.state.id === '_add'){
            reactivePower.reactivePowerId=''
            ReactivePowerService.createReactivePower(reactivePower).then(res =>{
                this.props.history.push('/reactivePowers');
            });
        }else{
            ReactivePowerService.updateReactivePower(reactivePower).then( res => {
                this.props.history.push('/reactivePowers');
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
        this.props.history.push('/reactivePowers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ReactivePower</h3>
        }else{
            return <h3 className="text-center">Update ReactivePower</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateReactivePower}>Save</button>
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

export default CreateReactivePowerComponent
