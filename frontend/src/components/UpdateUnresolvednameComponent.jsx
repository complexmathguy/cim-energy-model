import React, { Component } from 'react'
import UnresolvednameService from '../services/UnresolvednameService';

class UpdateUnresolvednameComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateUnresolvedname = this.updateUnresolvedname.bind(this);

    }

    componentDidMount(){
        UnresolvednameService.getUnresolvednameById(this.state.id).then( (res) =>{
            let unresolvedname = res.data;
            this.setState({
            });
        });
    }

    updateUnresolvedname = (e) => {
        e.preventDefault();
        let unresolvedname = {
            unresolvednameId: this.state.id,
        };
        console.log('unresolvedname => ' + JSON.stringify(unresolvedname));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnresolvednameService.updateUnresolvedname(unresolvedname).then( res => {
            this.props.history.push('/unresolvednames');
        });
    }


    cancel(){
        this.props.history.push('/unresolvednames');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Unresolvedname</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnresolvedname}>Save</button>
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

export default UpdateUnresolvednameComponent
