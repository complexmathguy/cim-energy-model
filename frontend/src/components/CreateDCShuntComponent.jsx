import React, { Component } from 'react'
import DCShuntService from '../services/DCShuntService';

class CreateDCShuntComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                capacitance: '',
                ratedUdc: '',
                resistance: ''
        }
        this.changecapacitanceHandler = this.changecapacitanceHandler.bind(this);
        this.changeratedUdcHandler = this.changeratedUdcHandler.bind(this);
        this.changeresistanceHandler = this.changeresistanceHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DCShuntService.getDCShuntById(this.state.id).then( (res) =>{
                let dCShunt = res.data;
                this.setState({
                    capacitance: dCShunt.capacitance,
                    ratedUdc: dCShunt.ratedUdc,
                    resistance: dCShunt.resistance
                });
            });
        }        
    }
    saveOrUpdateDCShunt = (e) => {
        e.preventDefault();
        let dCShunt = {
                dCShuntId: this.state.id,
                capacitance: this.state.capacitance,
                ratedUdc: this.state.ratedUdc,
                resistance: this.state.resistance
            };
        console.log('dCShunt => ' + JSON.stringify(dCShunt));

        // step 5
        if(this.state.id === '_add'){
            dCShunt.dCShuntId=''
            DCShuntService.createDCShunt(dCShunt).then(res =>{
                this.props.history.push('/dCShunts');
            });
        }else{
            DCShuntService.updateDCShunt(dCShunt).then( res => {
                this.props.history.push('/dCShunts');
            });
        }
    }
    
    changecapacitanceHandler= (event) => {
        this.setState({capacitance: event.target.value});
    }
    changeratedUdcHandler= (event) => {
        this.setState({ratedUdc: event.target.value});
    }
    changeresistanceHandler= (event) => {
        this.setState({resistance: event.target.value});
    }

    cancel(){
        this.props.history.push('/dCShunts');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCShunt</h3>
        }else{
            return <h3 className="text-center">Update DCShunt</h3>
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
                                            <label> capacitance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedUdc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> resistance: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCShunt}>Save</button>
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

export default CreateDCShuntComponent
