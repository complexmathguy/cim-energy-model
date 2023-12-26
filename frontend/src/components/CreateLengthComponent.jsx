import React, { Component } from 'react'
import LengthService from '../services/LengthService';

class CreateLengthComponent extends Component {
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
            LengthService.getLengthById(this.state.id).then( (res) =>{
                let length = res.data;
                this.setState({
                    multiplier: length.multiplier,
                    unit: length.unit,
                    value: length.value
                });
            });
        }        
    }
    saveOrUpdateLength = (e) => {
        e.preventDefault();
        let length = {
                lengthId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('length => ' + JSON.stringify(length));

        // step 5
        if(this.state.id === '_add'){
            length.lengthId=''
            LengthService.createLength(length).then(res =>{
                this.props.history.push('/lengths');
            });
        }else{
            LengthService.updateLength(length).then( res => {
                this.props.history.push('/lengths');
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
        this.props.history.push('/lengths');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Length</h3>
        }else{
            return <h3 className="text-center">Update Length</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLength}>Save</button>
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

export default CreateLengthComponent
