import React, { Component } from 'react'
import BayService from '../services/BayService';

class CreateBayComponent extends Component {
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
            BayService.getBayById(this.state.id).then( (res) =>{
                let bay = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateBay = (e) => {
        e.preventDefault();
        let bay = {
                bayId: this.state.id,
            };
        console.log('bay => ' + JSON.stringify(bay));

        // step 5
        if(this.state.id === '_add'){
            bay.bayId=''
            BayService.createBay(bay).then(res =>{
                this.props.history.push('/bays');
            });
        }else{
            BayService.updateBay(bay).then( res => {
                this.props.history.push('/bays');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/bays');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Bay</h3>
        }else{
            return <h3 className="text-center">Update Bay</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBay}>Save</button>
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

export default CreateBayComponent
