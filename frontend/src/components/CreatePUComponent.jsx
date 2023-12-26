import React, { Component } from 'react'
import PUService from '../services/PUService';

class CreatePUComponent extends Component {
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
            PUService.getPUById(this.state.id).then( (res) =>{
                let pU = res.data;
                this.setState({
                    multiplier: pU.multiplier,
                    unit: pU.unit,
                    value: pU.value
                });
            });
        }        
    }
    saveOrUpdatePU = (e) => {
        e.preventDefault();
        let pU = {
                pUId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('pU => ' + JSON.stringify(pU));

        // step 5
        if(this.state.id === '_add'){
            pU.pUId=''
            PUService.createPU(pU).then(res =>{
                this.props.history.push('/pUs');
            });
        }else{
            PUService.updatePU(pU).then( res => {
                this.props.history.push('/pUs');
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
        this.props.history.push('/pUs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PU</h3>
        }else{
            return <h3 className="text-center">Update PU</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePU}>Save</button>
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

export default CreatePUComponent
