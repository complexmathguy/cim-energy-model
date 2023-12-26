import React, { Component } from 'react'
import WindGenTurbineType3IECService from '../services/WindGenTurbineType3IECService';

class CreateWindGenTurbineType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                dipmax: '',
                diqmax: ''
        }
        this.changedipmaxHandler = this.changedipmaxHandler.bind(this);
        this.changediqmaxHandler = this.changediqmaxHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindGenTurbineType3IECService.getWindGenTurbineType3IECById(this.state.id).then( (res) =>{
                let windGenTurbineType3IEC = res.data;
                this.setState({
                    dipmax: windGenTurbineType3IEC.dipmax,
                    diqmax: windGenTurbineType3IEC.diqmax
                });
            });
        }        
    }
    saveOrUpdateWindGenTurbineType3IEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3IEC = {
                windGenTurbineType3IECId: this.state.id,
                dipmax: this.state.dipmax,
                diqmax: this.state.diqmax
            };
        console.log('windGenTurbineType3IEC => ' + JSON.stringify(windGenTurbineType3IEC));

        // step 5
        if(this.state.id === '_add'){
            windGenTurbineType3IEC.windGenTurbineType3IECId=''
            WindGenTurbineType3IECService.createWindGenTurbineType3IEC(windGenTurbineType3IEC).then(res =>{
                this.props.history.push('/windGenTurbineType3IECs');
            });
        }else{
            WindGenTurbineType3IECService.updateWindGenTurbineType3IEC(windGenTurbineType3IEC).then( res => {
                this.props.history.push('/windGenTurbineType3IECs');
            });
        }
    }
    
    changedipmaxHandler= (event) => {
        this.setState({dipmax: event.target.value});
    }
    changediqmaxHandler= (event) => {
        this.setState({diqmax: event.target.value});
    }

    cancel(){
        this.props.history.push('/windGenTurbineType3IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGenTurbineType3IEC</h3>
        }else{
            return <h3 className="text-center">Update WindGenTurbineType3IEC</h3>
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
                                            <label> dipmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> diqmax: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGenTurbineType3IEC}>Save</button>
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

export default CreateWindGenTurbineType3IECComponent
