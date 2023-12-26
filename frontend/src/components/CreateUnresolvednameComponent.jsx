import React, { Component } from 'react'
import UnresolvednameService from '../services/UnresolvednameService';

class CreateUnresolvednameComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            UnresolvednameService.getUnresolvednameById(this.state.id).then( (res) =>{
                let unresolvedname = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateUnresolvedname = (e) => {
        e.preventDefault();
        let unresolvedname = {
                unresolvednameId: this.state.id,
            };
        console.log('unresolvedname => ' + JSON.stringify(unresolvedname));

        // step 5
        if(this.state.id === '_add'){
            unresolvedname.unresolvednameId=''
            UnresolvednameService.createUnresolvedname(unresolvedname).then(res =>{
                this.props.history.push('/unresolvednames');
            });
        }else{
            UnresolvednameService.updateUnresolvedname(unresolvedname).then( res => {
                this.props.history.push('/unresolvednames');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/unresolvednames');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Unresolvedname</h3>
        }else{
            return <h3 className="text-center">Update Unresolvedname</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnresolvedname}>Save</button>
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

export default CreateUnresolvednameComponent
