import React, { Component } from 'react'
import WindGenTurbineType3aIECService from '../services/WindGenTurbineType3aIECService';

class CreateWindGenTurbineType3aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                kpc: '',
                tic: '',
                xs: ''
        }
        this.changekpcHandler = this.changekpcHandler.bind(this);
        this.changeticHandler = this.changeticHandler.bind(this);
        this.changexsHandler = this.changexsHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindGenTurbineType3aIECService.getWindGenTurbineType3aIECById(this.state.id).then( (res) =>{
                let windGenTurbineType3aIEC = res.data;
                this.setState({
                    kpc: windGenTurbineType3aIEC.kpc,
                    tic: windGenTurbineType3aIEC.tic,
                    xs: windGenTurbineType3aIEC.xs
                });
            });
        }        
    }
    saveOrUpdateWindGenTurbineType3aIEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3aIEC = {
                windGenTurbineType3aIECId: this.state.id,
                kpc: this.state.kpc,
                tic: this.state.tic,
                xs: this.state.xs
            };
        console.log('windGenTurbineType3aIEC => ' + JSON.stringify(windGenTurbineType3aIEC));

        // step 5
        if(this.state.id === '_add'){
            windGenTurbineType3aIEC.windGenTurbineType3aIECId=''
            WindGenTurbineType3aIECService.createWindGenTurbineType3aIEC(windGenTurbineType3aIEC).then(res =>{
                this.props.history.push('/windGenTurbineType3aIECs');
            });
        }else{
            WindGenTurbineType3aIECService.updateWindGenTurbineType3aIEC(windGenTurbineType3aIEC).then( res => {
                this.props.history.push('/windGenTurbineType3aIECs');
            });
        }
    }
    
    changekpcHandler= (event) => {
        this.setState({kpc: event.target.value});
    }
    changeticHandler= (event) => {
        this.setState({tic: event.target.value});
    }
    changexsHandler= (event) => {
        this.setState({xs: event.target.value});
    }

    cancel(){
        this.props.history.push('/windGenTurbineType3aIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGenTurbineType3aIEC</h3>
        }else{
            return <h3 className="text-center">Update WindGenTurbineType3aIEC</h3>
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
                                            <label> kpc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tic: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xs: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGenTurbineType3aIEC}>Save</button>
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

export default CreateWindGenTurbineType3aIECComponent
