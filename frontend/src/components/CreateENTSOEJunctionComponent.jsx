import React, { Component } from 'react'
import ENTSOEJunctionService from '../services/ENTSOEJunctionService';

class CreateENTSOEJunctionComponent extends Component {
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
            ENTSOEJunctionService.getENTSOEJunctionById(this.state.id).then( (res) =>{
                let eNTSOEJunction = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateENTSOEJunction = (e) => {
        e.preventDefault();
        let eNTSOEJunction = {
                eNTSOEJunctionId: this.state.id,
            };
        console.log('eNTSOEJunction => ' + JSON.stringify(eNTSOEJunction));

        // step 5
        if(this.state.id === '_add'){
            eNTSOEJunction.eNTSOEJunctionId=''
            ENTSOEJunctionService.createENTSOEJunction(eNTSOEJunction).then(res =>{
                this.props.history.push('/eNTSOEJunctions');
            });
        }else{
            ENTSOEJunctionService.updateENTSOEJunction(eNTSOEJunction).then( res => {
                this.props.history.push('/eNTSOEJunctions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/eNTSOEJunctions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ENTSOEJunction</h3>
        }else{
            return <h3 className="text-center">Update ENTSOEJunction</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateENTSOEJunction}>Save</button>
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

export default CreateENTSOEJunctionComponent
