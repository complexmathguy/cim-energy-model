import React, { Component } from 'react'
import NonlinearShuntCompensatorPointService from '../services/NonlinearShuntCompensatorPointService';

class CreateNonlinearShuntCompensatorPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                b: '',
                b0: '',
                g: '',
                g0: '',
                sectionNumber: ''
        }
        this.changebHandler = this.changebHandler.bind(this);
        this.changeb0Handler = this.changeb0Handler.bind(this);
        this.changegHandler = this.changegHandler.bind(this);
        this.changeg0Handler = this.changeg0Handler.bind(this);
        this.changesectionNumberHandler = this.changesectionNumberHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            NonlinearShuntCompensatorPointService.getNonlinearShuntCompensatorPointById(this.state.id).then( (res) =>{
                let nonlinearShuntCompensatorPoint = res.data;
                this.setState({
                    b: nonlinearShuntCompensatorPoint.b,
                    b0: nonlinearShuntCompensatorPoint.b0,
                    g: nonlinearShuntCompensatorPoint.g,
                    g0: nonlinearShuntCompensatorPoint.g0,
                    sectionNumber: nonlinearShuntCompensatorPoint.sectionNumber
                });
            });
        }        
    }
    saveOrUpdateNonlinearShuntCompensatorPoint = (e) => {
        e.preventDefault();
        let nonlinearShuntCompensatorPoint = {
                nonlinearShuntCompensatorPointId: this.state.id,
                b: this.state.b,
                b0: this.state.b0,
                g: this.state.g,
                g0: this.state.g0,
                sectionNumber: this.state.sectionNumber
            };
        console.log('nonlinearShuntCompensatorPoint => ' + JSON.stringify(nonlinearShuntCompensatorPoint));

        // step 5
        if(this.state.id === '_add'){
            nonlinearShuntCompensatorPoint.nonlinearShuntCompensatorPointId=''
            NonlinearShuntCompensatorPointService.createNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint).then(res =>{
                this.props.history.push('/nonlinearShuntCompensatorPoints');
            });
        }else{
            NonlinearShuntCompensatorPointService.updateNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint).then( res => {
                this.props.history.push('/nonlinearShuntCompensatorPoints');
            });
        }
    }
    
    changebHandler= (event) => {
        this.setState({b: event.target.value});
    }
    changeb0Handler= (event) => {
        this.setState({b0: event.target.value});
    }
    changegHandler= (event) => {
        this.setState({g: event.target.value});
    }
    changeg0Handler= (event) => {
        this.setState({g0: event.target.value});
    }
    changesectionNumberHandler= (event) => {
        this.setState({sectionNumber: event.target.value});
    }

    cancel(){
        this.props.history.push('/nonlinearShuntCompensatorPoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add NonlinearShuntCompensatorPoint</h3>
        }else{
            return <h3 className="text-center">Update NonlinearShuntCompensatorPoint</h3>
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
                                            <label> b: </label>
                                            #formFields( $attribute, 'create')
                                            <label> b0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> g: </label>
                                            #formFields( $attribute, 'create')
                                            <label> g0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> sectionNumber: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateNonlinearShuntCompensatorPoint}>Save</button>
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

export default CreateNonlinearShuntCompensatorPointComponent
