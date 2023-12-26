import React, { Component } from 'react'
import EquivalentShuntService from '../services/EquivalentShuntService';

class UpdateEquivalentShuntComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                b: '',
                g: ''
        }
        this.updateEquivalentShunt = this.updateEquivalentShunt.bind(this);

        this.changebHandler = this.changebHandler.bind(this);
        this.changegHandler = this.changegHandler.bind(this);
    }

    componentDidMount(){
        EquivalentShuntService.getEquivalentShuntById(this.state.id).then( (res) =>{
            let equivalentShunt = res.data;
            this.setState({
                b: equivalentShunt.b,
                g: equivalentShunt.g
            });
        });
    }

    updateEquivalentShunt = (e) => {
        e.preventDefault();
        let equivalentShunt = {
            equivalentShuntId: this.state.id,
            b: this.state.b,
            g: this.state.g
        };
        console.log('equivalentShunt => ' + JSON.stringify(equivalentShunt));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquivalentShuntService.updateEquivalentShunt(equivalentShunt).then( res => {
            this.props.history.push('/equivalentShunts');
        });
    }

    changebHandler= (event) => {
        this.setState({b: event.target.value});
    }
    changegHandler= (event) => {
        this.setState({g: event.target.value});
    }

    cancel(){
        this.props.history.push('/equivalentShunts');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquivalentShunt</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> b: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquivalentShunt}>Save</button>
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

export default UpdateEquivalentShuntComponent
