import React, { Component } from 'react'
import OverexcLim2Service from '../services/OverexcLim2Service';

class UpdateOverexcLim2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ifdlim: '',
                koi: '',
                voimax: '',
                voimin: ''
        }
        this.updateOverexcLim2 = this.updateOverexcLim2.bind(this);

        this.changeifdlimHandler = this.changeifdlimHandler.bind(this);
        this.changekoiHandler = this.changekoiHandler.bind(this);
        this.changevoimaxHandler = this.changevoimaxHandler.bind(this);
        this.changevoiminHandler = this.changevoiminHandler.bind(this);
    }

    componentDidMount(){
        OverexcLim2Service.getOverexcLim2ById(this.state.id).then( (res) =>{
            let overexcLim2 = res.data;
            this.setState({
                ifdlim: overexcLim2.ifdlim,
                koi: overexcLim2.koi,
                voimax: overexcLim2.voimax,
                voimin: overexcLim2.voimin
            });
        });
    }

    updateOverexcLim2 = (e) => {
        e.preventDefault();
        let overexcLim2 = {
            overexcLim2Id: this.state.id,
            ifdlim: this.state.ifdlim,
            koi: this.state.koi,
            voimax: this.state.voimax,
            voimin: this.state.voimin
        };
        console.log('overexcLim2 => ' + JSON.stringify(overexcLim2));
        console.log('id => ' + JSON.stringify(this.state.id));
        OverexcLim2Service.updateOverexcLim2(overexcLim2).then( res => {
            this.props.history.push('/overexcLim2s');
        });
    }

    changeifdlimHandler= (event) => {
        this.setState({ifdlim: event.target.value});
    }
    changekoiHandler= (event) => {
        this.setState({koi: event.target.value});
    }
    changevoimaxHandler= (event) => {
        this.setState({voimax: event.target.value});
    }
    changevoiminHandler= (event) => {
        this.setState({voimin: event.target.value});
    }

    cancel(){
        this.props.history.push('/overexcLim2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OverexcLim2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ifdlim: </label>
                                            #formFields( $attribute, 'update')
                                            <label> koi: </label>
                                            #formFields( $attribute, 'update')
                                            <label> voimax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> voimin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOverexcLim2}>Save</button>
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

export default UpdateOverexcLim2Component
