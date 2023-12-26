import React, { Component } from 'react'
import WindContPType4bIECService from '../services/WindContPType4bIECService';

class CreateWindContPType4bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                dpmax: '',
                tpaero: '',
                tpord: '',
                tufilt: ''
        }
        this.changedpmaxHandler = this.changedpmaxHandler.bind(this);
        this.changetpaeroHandler = this.changetpaeroHandler.bind(this);
        this.changetpordHandler = this.changetpordHandler.bind(this);
        this.changetufiltHandler = this.changetufiltHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindContPType4bIECService.getWindContPType4bIECById(this.state.id).then( (res) =>{
                let windContPType4bIEC = res.data;
                this.setState({
                    dpmax: windContPType4bIEC.dpmax,
                    tpaero: windContPType4bIEC.tpaero,
                    tpord: windContPType4bIEC.tpord,
                    tufilt: windContPType4bIEC.tufilt
                });
            });
        }        
    }
    saveOrUpdateWindContPType4bIEC = (e) => {
        e.preventDefault();
        let windContPType4bIEC = {
                windContPType4bIECId: this.state.id,
                dpmax: this.state.dpmax,
                tpaero: this.state.tpaero,
                tpord: this.state.tpord,
                tufilt: this.state.tufilt
            };
        console.log('windContPType4bIEC => ' + JSON.stringify(windContPType4bIEC));

        // step 5
        if(this.state.id === '_add'){
            windContPType4bIEC.windContPType4bIECId=''
            WindContPType4bIECService.createWindContPType4bIEC(windContPType4bIEC).then(res =>{
                this.props.history.push('/windContPType4bIECs');
            });
        }else{
            WindContPType4bIECService.updateWindContPType4bIEC(windContPType4bIEC).then( res => {
                this.props.history.push('/windContPType4bIECs');
            });
        }
    }
    
    changedpmaxHandler= (event) => {
        this.setState({dpmax: event.target.value});
    }
    changetpaeroHandler= (event) => {
        this.setState({tpaero: event.target.value});
    }
    changetpordHandler= (event) => {
        this.setState({tpord: event.target.value});
    }
    changetufiltHandler= (event) => {
        this.setState({tufilt: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContPType4bIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContPType4bIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContPType4bIEC</h3>
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
                                            <label> dpmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpaero: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpord: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tufilt: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContPType4bIEC}>Save</button>
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

export default CreateWindContPType4bIECComponent
