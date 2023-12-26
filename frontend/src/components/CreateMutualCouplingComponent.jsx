import React, { Component } from 'react'
import MutualCouplingService from '../services/MutualCouplingService';

class CreateMutualCouplingComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                b0ch: '',
                distance11: '',
                distance12: '',
                distance21: '',
                distance22: '',
                g0ch: '',
                r0: '',
                x0: ''
        }
        this.changeb0chHandler = this.changeb0chHandler.bind(this);
        this.changedistance11Handler = this.changedistance11Handler.bind(this);
        this.changedistance12Handler = this.changedistance12Handler.bind(this);
        this.changedistance21Handler = this.changedistance21Handler.bind(this);
        this.changedistance22Handler = this.changedistance22Handler.bind(this);
        this.changeg0chHandler = this.changeg0chHandler.bind(this);
        this.changer0Handler = this.changer0Handler.bind(this);
        this.changex0Handler = this.changex0Handler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            MutualCouplingService.getMutualCouplingById(this.state.id).then( (res) =>{
                let mutualCoupling = res.data;
                this.setState({
                    b0ch: mutualCoupling.b0ch,
                    distance11: mutualCoupling.distance11,
                    distance12: mutualCoupling.distance12,
                    distance21: mutualCoupling.distance21,
                    distance22: mutualCoupling.distance22,
                    g0ch: mutualCoupling.g0ch,
                    r0: mutualCoupling.r0,
                    x0: mutualCoupling.x0
                });
            });
        }        
    }
    saveOrUpdateMutualCoupling = (e) => {
        e.preventDefault();
        let mutualCoupling = {
                mutualCouplingId: this.state.id,
                b0ch: this.state.b0ch,
                distance11: this.state.distance11,
                distance12: this.state.distance12,
                distance21: this.state.distance21,
                distance22: this.state.distance22,
                g0ch: this.state.g0ch,
                r0: this.state.r0,
                x0: this.state.x0
            };
        console.log('mutualCoupling => ' + JSON.stringify(mutualCoupling));

        // step 5
        if(this.state.id === '_add'){
            mutualCoupling.mutualCouplingId=''
            MutualCouplingService.createMutualCoupling(mutualCoupling).then(res =>{
                this.props.history.push('/mutualCouplings');
            });
        }else{
            MutualCouplingService.updateMutualCoupling(mutualCoupling).then( res => {
                this.props.history.push('/mutualCouplings');
            });
        }
    }
    
    changeb0chHandler= (event) => {
        this.setState({b0ch: event.target.value});
    }
    changedistance11Handler= (event) => {
        this.setState({distance11: event.target.value});
    }
    changedistance12Handler= (event) => {
        this.setState({distance12: event.target.value});
    }
    changedistance21Handler= (event) => {
        this.setState({distance21: event.target.value});
    }
    changedistance22Handler= (event) => {
        this.setState({distance22: event.target.value});
    }
    changeg0chHandler= (event) => {
        this.setState({g0ch: event.target.value});
    }
    changer0Handler= (event) => {
        this.setState({r0: event.target.value});
    }
    changex0Handler= (event) => {
        this.setState({x0: event.target.value});
    }

    cancel(){
        this.props.history.push('/mutualCouplings');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MutualCoupling</h3>
        }else{
            return <h3 className="text-center">Update MutualCoupling</h3>
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
                                            <label> b0ch: </label>
                                            #formFields( $attribute, 'create')
                                            <label> distance11: </label>
                                            #formFields( $attribute, 'create')
                                            <label> distance12: </label>
                                            #formFields( $attribute, 'create')
                                            <label> distance21: </label>
                                            #formFields( $attribute, 'create')
                                            <label> distance22: </label>
                                            #formFields( $attribute, 'create')
                                            <label> g0ch: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMutualCoupling}>Save</button>
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

export default CreateMutualCouplingComponent
