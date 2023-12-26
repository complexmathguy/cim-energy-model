import React, { Component } from 'react'
import EquivalentBranchService from '../services/EquivalentBranchService';

class UpdateEquivalentBranchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                negativeR12: '',
                negativeR21: '',
                negativeX12: '',
                negativeX21: '',
                positiveR12: '',
                positiveR21: '',
                positiveX12: '',
                positiveX21: '',
                r: '',
                r21: '',
                x: '',
                x21: '',
                zeroR12: '',
                zeroR21: '',
                zeroX12: '',
                zeroX21: ''
        }
        this.updateEquivalentBranch = this.updateEquivalentBranch.bind(this);

        this.changenegativeR12Handler = this.changenegativeR12Handler.bind(this);
        this.changenegativeR21Handler = this.changenegativeR21Handler.bind(this);
        this.changenegativeX12Handler = this.changenegativeX12Handler.bind(this);
        this.changenegativeX21Handler = this.changenegativeX21Handler.bind(this);
        this.changepositiveR12Handler = this.changepositiveR12Handler.bind(this);
        this.changepositiveR21Handler = this.changepositiveR21Handler.bind(this);
        this.changepositiveX12Handler = this.changepositiveX12Handler.bind(this);
        this.changepositiveX21Handler = this.changepositiveX21Handler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changer21Handler = this.changer21Handler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
        this.changex21Handler = this.changex21Handler.bind(this);
        this.changezeroR12Handler = this.changezeroR12Handler.bind(this);
        this.changezeroR21Handler = this.changezeroR21Handler.bind(this);
        this.changezeroX12Handler = this.changezeroX12Handler.bind(this);
        this.changezeroX21Handler = this.changezeroX21Handler.bind(this);
    }

    componentDidMount(){
        EquivalentBranchService.getEquivalentBranchById(this.state.id).then( (res) =>{
            let equivalentBranch = res.data;
            this.setState({
                negativeR12: equivalentBranch.negativeR12,
                negativeR21: equivalentBranch.negativeR21,
                negativeX12: equivalentBranch.negativeX12,
                negativeX21: equivalentBranch.negativeX21,
                positiveR12: equivalentBranch.positiveR12,
                positiveR21: equivalentBranch.positiveR21,
                positiveX12: equivalentBranch.positiveX12,
                positiveX21: equivalentBranch.positiveX21,
                r: equivalentBranch.r,
                r21: equivalentBranch.r21,
                x: equivalentBranch.x,
                x21: equivalentBranch.x21,
                zeroR12: equivalentBranch.zeroR12,
                zeroR21: equivalentBranch.zeroR21,
                zeroX12: equivalentBranch.zeroX12,
                zeroX21: equivalentBranch.zeroX21
            });
        });
    }

    updateEquivalentBranch = (e) => {
        e.preventDefault();
        let equivalentBranch = {
            equivalentBranchId: this.state.id,
            negativeR12: this.state.negativeR12,
            negativeR21: this.state.negativeR21,
            negativeX12: this.state.negativeX12,
            negativeX21: this.state.negativeX21,
            positiveR12: this.state.positiveR12,
            positiveR21: this.state.positiveR21,
            positiveX12: this.state.positiveX12,
            positiveX21: this.state.positiveX21,
            r: this.state.r,
            r21: this.state.r21,
            x: this.state.x,
            x21: this.state.x21,
            zeroR12: this.state.zeroR12,
            zeroR21: this.state.zeroR21,
            zeroX12: this.state.zeroX12,
            zeroX21: this.state.zeroX21
        };
        console.log('equivalentBranch => ' + JSON.stringify(equivalentBranch));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquivalentBranchService.updateEquivalentBranch(equivalentBranch).then( res => {
            this.props.history.push('/equivalentBranchs');
        });
    }

    changenegativeR12Handler= (event) => {
        this.setState({negativeR12: event.target.value});
    }
    changenegativeR21Handler= (event) => {
        this.setState({negativeR21: event.target.value});
    }
    changenegativeX12Handler= (event) => {
        this.setState({negativeX12: event.target.value});
    }
    changenegativeX21Handler= (event) => {
        this.setState({negativeX21: event.target.value});
    }
    changepositiveR12Handler= (event) => {
        this.setState({positiveR12: event.target.value});
    }
    changepositiveR21Handler= (event) => {
        this.setState({positiveR21: event.target.value});
    }
    changepositiveX12Handler= (event) => {
        this.setState({positiveX12: event.target.value});
    }
    changepositiveX21Handler= (event) => {
        this.setState({positiveX21: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changer21Handler= (event) => {
        this.setState({r21: event.target.value});
    }
    changexHandler= (event) => {
        this.setState({x: event.target.value});
    }
    changex21Handler= (event) => {
        this.setState({x21: event.target.value});
    }
    changezeroR12Handler= (event) => {
        this.setState({zeroR12: event.target.value});
    }
    changezeroR21Handler= (event) => {
        this.setState({zeroR21: event.target.value});
    }
    changezeroX12Handler= (event) => {
        this.setState({zeroX12: event.target.value});
    }
    changezeroX21Handler= (event) => {
        this.setState({zeroX21: event.target.value});
    }

    cancel(){
        this.props.history.push('/equivalentBranchs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquivalentBranch</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> negativeR12: </label>
                                            #formFields( $attribute, 'update')
                                            <label> negativeR21: </label>
                                            #formFields( $attribute, 'update')
                                            <label> negativeX12: </label>
                                            #formFields( $attribute, 'update')
                                            <label> negativeX21: </label>
                                            #formFields( $attribute, 'update')
                                            <label> positiveR12: </label>
                                            #formFields( $attribute, 'update')
                                            <label> positiveR21: </label>
                                            #formFields( $attribute, 'update')
                                            <label> positiveX12: </label>
                                            #formFields( $attribute, 'update')
                                            <label> positiveX21: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r21: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x21: </label>
                                            #formFields( $attribute, 'update')
                                            <label> zeroR12: </label>
                                            #formFields( $attribute, 'update')
                                            <label> zeroR21: </label>
                                            #formFields( $attribute, 'update')
                                            <label> zeroX12: </label>
                                            #formFields( $attribute, 'update')
                                            <label> zeroX21: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquivalentBranch}>Save</button>
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

export default UpdateEquivalentBranchComponent
