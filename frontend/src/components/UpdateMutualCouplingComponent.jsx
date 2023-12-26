import React, { Component } from 'react'
import MutualCouplingService from '../services/MutualCouplingService';

class UpdateMutualCouplingComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
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
        this.updateMutualCoupling = this.updateMutualCoupling.bind(this);

        this.changeb0chHandler = this.changeb0chHandler.bind(this);
        this.changedistance11Handler = this.changedistance11Handler.bind(this);
        this.changedistance12Handler = this.changedistance12Handler.bind(this);
        this.changedistance21Handler = this.changedistance21Handler.bind(this);
        this.changedistance22Handler = this.changedistance22Handler.bind(this);
        this.changeg0chHandler = this.changeg0chHandler.bind(this);
        this.changer0Handler = this.changer0Handler.bind(this);
        this.changex0Handler = this.changex0Handler.bind(this);
    }

    componentDidMount(){
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

    updateMutualCoupling = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        MutualCouplingService.updateMutualCoupling(mutualCoupling).then( res => {
            this.props.history.push('/mutualCouplings');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MutualCoupling</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> b0ch: </label>
                                            #formFields( $attribute, 'update')
                                            <label> distance11: </label>
                                            #formFields( $attribute, 'update')
                                            <label> distance12: </label>
                                            #formFields( $attribute, 'update')
                                            <label> distance21: </label>
                                            #formFields( $attribute, 'update')
                                            <label> distance22: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g0ch: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMutualCoupling}>Save</button>
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

export default UpdateMutualCouplingComponent
