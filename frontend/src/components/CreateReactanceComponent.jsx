import React, { Component } from 'react'
import ReactanceService from '../services/ReactanceService';

class CreateReactanceComponent extends Component {
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
            ReactanceService.getReactanceById(this.state.id).then( (res) =>{
                let reactance = res.data;
                this.setState({
                    multiplier: reactance.multiplier,
                    unit: reactance.unit,
                    value: reactance.value
                });
            });
        }        
    }
    saveOrUpdateReactance = (e) => {
        e.preventDefault();
        let reactance = {
                reactanceId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('reactance => ' + JSON.stringify(reactance));

        // step 5
        if(this.state.id === '_add'){
            reactance.reactanceId=''
            ReactanceService.createReactance(reactance).then(res =>{
                this.props.history.push('/reactances');
            });
        }else{
            ReactanceService.updateReactance(reactance).then( res => {
                this.props.history.push('/reactances');
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
        this.props.history.push('/reactances');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Reactance</h3>
        }else{
            return <h3 className="text-center">Update Reactance</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateReactance}>Save</button>
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

export default CreateReactanceComponent
